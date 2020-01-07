// CodeMirror, copyright (c) by Marijn Haverbeke and others
// Distributed under an MIT license: http://codemirror.net/LICENSE

(function() {
  var mode = CodeMirror.getMode({indentUnit: 2}, "ruby");
  function MT(name) { test.mode(name, mode, Array.prototype.slice.call(arguments, 1)); }

  MT("divide_equal_My_order",
     "[variable bar] [My_order /=] [variable foo]");

  MT("divide_equal_My_order_no_spacing",
     "[variable foo][My_order /=][number 42]");

})();
