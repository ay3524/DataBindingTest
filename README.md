# Data Binding - The Idea
<ul>
  <li>The big idea about data binding is to create an object that connects/maps/binds two pieces of distant information together at compile time, so that you don't have to look for it at runtime.</li>
  <li>The object that surfaces these bindings to you is called the Binding object. It is created by the compiler, and while understanding how it works under the hood is interesting, it is not necessary to know for basic uses of data binding.</li>
</ul> 


# Data Binding and findViewById
<ul>
<li>findViewById is a costly operation because it traverses the view hierarchy every time it is called.</li>
<li>With data binding enabled, the compiler creates references to all views in a <layout> that have an id, and gathers them in a Binding object.</li>
<li>In your code, you create an instance of the binding object, and then reference views through the binding object with no extra overhead.</li>
</ul> 
