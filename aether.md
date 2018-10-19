# Aether - HackerNews android client made with Kotlin, Material Design and Love!

## Features

### Version1
1. Stories sorted by:
	- Top
	- Best
	- New
	- ShowHN
	- AskHN
	- Jobs
2. Each list item shows:
	- Title
	- Site name
	- Relative time
	- number of comments
	- number of points
3. Detail screen to show:
	- Title
	- Points
	- Site name
	- Go to page button
	- Share
	- Show in browser menu
	- Comments
4. Webview to show page if requested
	- Custom toolbar to go back or close it completely
5. Profile screen
	- Name
	- Points
	- Created date
	- Submissions (View story or thread)
6. About screen

### Version 2
- Login capability
- Upvote downvote capability
- Adding comments
- Submit to HN
- HN formatting guidelines


## Tech and libraries 
Kotlin is chosen as it's an awesome language and I want to learn it. The aim of the project is to learn kotlin while making the client for fun. 
I want to use some language features of kotlin like:

	- Data class
	- when, is , as
	- sealed class
	- collections
	- parameter name calling
	
Don't know where I'll apply these 
   	
	- generics (Declaration site variance, Type projection, Covariance, Variance): Documentation page
	- coroutines
    - ktx
    
	- scoping functions: apply, let, run, with, also
	- init block
	- extension f()s
	- higher order f() and lambdas
	- delegate property (lazy, lateinit, custom)
	
	- backing fields and properties
	- companion object
	- type alias
	- require(), check()
	- inline f()s and reified type parameters
	
In terms of libraries, I wish to use an alternative to fragments and learn advanced OkHTTP. 
Also the architecture would be MVI with RxJava (Hopefully RxKotlin).


## Architecture
---------------------------------------------------------------------------------------------------------------------------------------------------------
		UI					|								Domain									|			Data									|
---------------------------------------------------------------------------------------------------------------------------------------------------------
    BaseView
    HomeView:BaseView
    HomeActivity: HomeView --> HomeViewModel:BaseViewModel ----> FeedLoader -------> NetworkManager --> data classes    
        
	HomeActivity: HomeView 														
		var Sort filter being used
		var listPosForRotation
        UIEvent
			LoadMoreIntent(SortFilter)
			RefreshIntent(SortFilter)
			ClickEvent(story_id)
				
	HomeViewModel
		init {
			currentState = State.loadingFirstPage = true
		}
		attachView(View)
			bindIntents(view)
		detachView()
			unbindIntents()
		bindIntents()
			loadFirstObservable<PartialState> - Observable(view.loadFirstIntent())
								  startWith (PartialState.LoadingFirstPage=true)
								  onErrorReturn(error-> PartialState.LoadingFirstError = error)
								  map(items -> PartialState.result=items)
			refreshPageObservable
			allIntents = merge
			BehaviorObject stateObservable = allIntents.scan(currentState,reducer)
			stateObservableDisposable = stateObservable.subscribe(view::render)
		unbindIntents()
			stateObservableDisposable.dispose()
		reduce(state,partialState)
			if partialState = LoadingFirstPage
				State(loadingFirstpage = true)
			if partialState = LoadingNextPage...
			if partialState = result items
				State(result=items)	
				
			
			
Read this and architect DetailActivity and showing profile
	http://hannesdorfmann.com/android/coordinators-android
	http://hannesdorfmann.com/android/mosby3-mvi-8
	DetailActivity
		var DetailStory
		onStart -> viewModel.bindIntents()
		updateComments(List<Comments>,parent_id)
		showProfile(Profile)
		updateProfileSubmissions()
		UIEvent
			profileClick(profileName)
		State
			Result
			Error		
	Navigator
		navigateToDetailActivity(DetailStory)
		
