# Data Binding - The Idea
<ul>
  <li>The big idea about data binding is to create an object that connects/maps/binds two pieces of distant information together at compile time, so that you don't have to look for it at runtime.</li>
  <li>The object that surfaces these bindings to you is called the Binding object. It is created by the compiler, and while understanding how it works under the hood is interesting, it is not necessary to know for basic uses of data binding.</li>
</ul> 


# Data Binding and findViewById
<ul>
<li>findViewById is a costly operation because it traverses the view hierarchy every time it is called.</li>
<li>With data binding enabled, the compiler creates references to all views in a "layout" that have an id, and gathers them in a Binding object.</li>
<li>In our code, we create an instance of the binding object, and then reference views through the binding object with no extra overhead.</li>
</ul> 

<br>

![Data Binding Image](https://github.com/ay3524/DataBindingTest/raw/master/4704sc-a-layoutsdata-binding-intro-slide.png)<br>


# Data Binding Views and Data
<ul>
<li>Updating data and then updating the data displayed in views is cumbersome and a source of errors. Keeping the data in the view also violates separation of data and presentation.</li>
<li>Data binding solves both of these problems. We keep data in a data class. We add a "data" block to the "layout" to identify the data as variables to use with the views. Views reference the variables.</li> 
<li>The compiler generates a binding object that binds the views and data.</li>
<li>In our code, we reference and update the data through the binding object, which updates the data, and thus what is displayed in the view.</li>
<li>Binding views to data sets a foundation for more advanced techniques using data binding.</li>
</ul> 

<br>

![Data Binding Image](https://github.com/ay3524/DataBindingTest/raw/master/l2-5203sc-alayoutsdata-binding-data-slide.png)<br>

# Steps to acheive
  1. Enabling data binding in our build.gradle file in the app module inside the android section:<br>

```groovy
dataBinding {
enabled = true
}
```
2. Wrap all views in activity_main.xml into a "layout" tag, and move the namespace declarations into the the "layout" tag.<br>
3. In MainActivity, create a binding object:<br>
```kotlin
private lateinit var binding: ActivityMainBinding
```
4. In onCreate, use DataBindingUtil to set the content view:<br>
```kotlin
binding = DataBindingUtil.setContentView(this, R.layout.actity_main)
```
5. Use the binding object to replace all calls to findViewById, for example:<br>
```kotlin
binding.doneButton.setOnClickListener….etc
```
 <strong>Hint</strong>: We can use apply() in the click handler to make your code more concise and readable.<br>
1. Create a data class Hello for both the TextViews.<br>
```kotlin
data class Hello(var text: String = "", var text1: String = "")
```
2. Add a <data> block to activity_main.xml. The data block goes inside the layout tag but before the view tags. Inside the data block, add a variable for the MyName class.<br>
```xml
<data>
<!-- Declare a variable by specifying a name and a data type. -->
<!-- Use fully qualified name for the type. -->
<variable
    name="hello"
    type="com.ay3524.databindingtest.Hello" />
</data>
```
3. In text_view1, and text_view2,we replace the references to string text resources with references to the variables, for example :<br>
```xml
//For 1st TextView
android:text="@={hello.text}"
//For 2nd TextView
android:text="@={hello.text1}"
```
4. In MainActivity, we create an instance of Hello.<br>
```kotlin
// Instance of MyName data class.
private val hello: Hello = Hello(
        "Hello Fom Data Binding for 1st text",
        "Hello Fom Data Binding for 2nd text")
```
5. And in onCreate(), set binding.hello to it.<br>
```kotlin
binding.hello = hello
```
6. In performBindingOperation(), set the value of text1 in hello, call invalidateAll(), and the data should show in our views.<br>
```kotlin
// Changing the text
hello?.text1 = "Just a test text"
// Invalidate all binding expressions and request a new rebind to refresh UI
invalidateAll()
```
