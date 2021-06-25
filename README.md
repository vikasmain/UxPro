# UxPro


https://user-images.githubusercontent.com/20916492/123371913-3c6a1180-d5a0-11eb-8582-d761a352a4ac.mp4

<img src="https://user-images.githubusercontent.com/20916492/123372033-74715480-d5a0-11eb-9f77-7f9195c9e44f.jpg" width="200" height="400">


## It shows list of all ux components in android in recycler view and shows what are the various types of ux components are available in android.

## Architectural Pattern
it represents the abstraction part of app.

Used MVVM architecture here
## What is MVVM?

### Model: It represents the data and the business logic of the Android Application. It consists of the business logic - local and remote data source, model classes, repository.

### View: It consists of the UI Code(Activity, Fragment), XML. It sends the user action to the ViewModel but does not get the response back directly. To get the response, it has to subscribe to the observables which ViewModel exposes to it.

### ViewModel: It is a bridge between the View and Model(business logic). It does not have any clue which View has to use it as it does not have a direct reference to the View. So basically, the ViewModel should not be aware of the view who is interacting with. It interacts with the Model and exposes the observable that can be observed by the View.

check out this blog for more details:- https://blog.mindorks.com/mvvm-architecture-android-tutorial-for-beginners-step-by-step-guide

### LiveData
it is an android architecture component. LiveData is just a data type which notifies it’s observer whenever the data is changed. LiveData is like a data changed notifier. Android LiveData is somewhat similar to RxJava except that LiveData is lifecycle aware. It won’t update your data in the view if the View is in the background. This helps us in avoiding exceptions like IllegalStateException etc.
check out this for more:- https://www.journaldev.com/21168/android-livedata#:~:text=LiveData%20is%20based%20on%20the,SQLite%2C%20ArrayList%2C%20ViewModel)
