# Cover Autocomplete
This is a solution for the Autocomplete assignment of Cover at [Github] (https://gist.github.com/anand180/a6f0476514406e3397d34ad0e55334fa)
## Major tasks completed
1. Navigation Android Architecture Component
2. Screen 1 - Address Autocomplete by a) Place Autocomplete Widget, and b) AutoCompleteTextView + Place Autocomplete Adapter
3. Screen 2 - Insurance Carriers Autocomplete by AutoCompleteTextView
4. On-screen blank input reminder instead of pop-up alert dialog
5. Separation UI from data/adapters
6. Testing in Android Emulator and mobile phones in debugging mode
## Architecture
For any non-simple Android app, MVVM under the official Android guide to app architecture shall be one of the best choices. Yet for this assignment, MVVM would be an overkill. MVC is a perfectly fine architecture for now - when more business logic, data, and UI elements flow in, it may be adapted to the MVVM pattern.
## Styling
Cover Android mobile app is referenced.
1. Primary text color: red like
2. Accent color: blue like
3. Toolbar background color(s): white; title centered and bolded
## Choices for Google Places Autocomplete API calls
1. Place Autocomplete Widget (implemented in branch **autocomplete_widget**. Coding is very simple and neat. The defect of this method is that UI of the widget is much inflexible, and it is hard to get the text from the EditText view inside the widget.
2. Dynamically programming with Google Place Autocomplete Adapter (implemented in branch **network** and merged into branch **master**). This is currently the best choice, offering decently neat code and flexible UI controls.
3. RESTful API calls with Retrofit + RxJava/RxAndroid / Kotlin Coroutines + Retrofit JSON Converter + Retrofit RxJava Adapter / Retrofit Kotlin Coroutines Adapter. If not with 2, this would be a decent choice, and would be a great solution when the native support like that of Google Place Autocomplete Adapter is absent.
## Choices of JSON file sources
1. Get JSON file as a local asset (implemented)
2. Get JSON file from Cloud storage
3. Get JSON package for the return of a RESTful API call
## Alternative to the pop-up alert dialog
The assignment description asks for pop-up alert dialog for empty input. From the UI perspective, it would be preferred to show an error reminder on the same screens (or less elegantly a Toast/Snackbar message) without pop-up an extra dialog that would bother users to click. The implementation does the following:
1. If the input is blank (including space etc.), when **NEXT** button is pressed, on-screen reminder with yellow like color is shown.
2. When an autocomplete item is selected, the error reminder disappears, and accent color restores to blue like.
## What's next?
Some enhancements may be done as follows:
1. Better Toast prompt when the Internet is not connected
2. Location-aware places prioritization for autocomplete
3. Cache/storage of selected place(s)
4. More interaction(s) with selected item(s)
## Misc
The "powered by Google" logo is added on Screen 1 per Google's requirement for using the API: "If your app uses the autocomplete service programmatically, your UI must either display a 'Powered by Google' attribution, or appear within a Google-branded map." (https://developers.google.com/places/android-sdk/autocomplete)