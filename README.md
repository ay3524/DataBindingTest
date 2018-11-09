# Data Binding - The Idea
<ul>
  <li>The big idea about data binding is to create an object that connects/maps/binds two pieces of distant information together at compile time, so that you don't have to look for it at runtime.</li>
  <li>The object that surfaces these bindings to you is called the Binding object. It is created by the compiler, and while understanding how it works under the hood is interesting, it is not necessary to know for basic uses of data binding.</li>
</ul> 


# Data Binding and findViewById
<ul>
<li>findViewById is a costly operation because it traverses the view hierarchy every time it is called.</li>
<li>With data binding enabled, the compiler creates references to all views in a "layout" that have an id, and gathers them in a Binding object.</li>
<li>In your code, you create an instance of the binding object, and then reference views through the binding object with no extra overhead.</li>
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

