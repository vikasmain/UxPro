# UxPro
## It shows list of all ux components in android in recycler view and shows what are the various types of ux components are available in android.

## Architectural Pattern
it represents the abstraction part of app.

Used MVVM architecture here
## What is MVVM?

Model: It represents the data and the business logic of the Android Application. It consists of the business logic - local and remote data source, model classes, repository.
View: It consists of the UI Code(Activity, Fragment), XML. It sends the user action to the ViewModel but does not get the response back directly. To get the response, it has to subscribe to the observables which ViewModel exposes to it.
ViewModel: It is a bridge between the View and Model(business logic). It does not have any clue which View has to use it as it does not have a direct reference to the View. So basically, the ViewModel should not be aware of the view who is interacting with. It interacts with the Model and exposes the observable that can be observed by the View.

check out this blog for more details:- https://blog.mindorks.com/mvvm-architecture-android-tutorial-for-beginners-step-by-step-guide
