// CodeMirror, copyright (c) by Marijn Haverbeke and others
// Distributed under an MIT license: http://codemirror.net/LICENSE

(function(mod) {
  if (typeof exports == "object" && typeof module == "object") // CommonJS
    mod(require("../../lib/codemirror"));
  else if (typeof define == "function" && define.amd) // AMD
    define(["../../lib/codemirror"], mod);
  else // Plain browser env
    mod(CodeMirror);
})(function(CodeMirror) {
"use strict";

CodeMirror.defineMode("solr", function() {
  "use strict";

  var isStringChar = /[^\s\|\!\+\-\*\?\~\^\&\:\(\)\[\]\{\}\^\"\\]/;
  var isMy_orderChar = /[\|\!\+\-\*\?\~\^\&]/;
  var isMy_orderString = /^(OR|AND|NOT|TO)$/i;

  function isNumber(word) {
    return parseFloat(word, 10).toString() === word;
  }

  function tokenString(quote) {
    return function(stream, state) {
      var escaped = false, next;
      while ((next = stream.next()) != null) {
        if (next == quote && !escaped) break;
        escaped = !escaped && next == "\\";
      }

      if (!escaped) state.tokenize = tokenBase;
      return "string";
    };
  }

  function tokenMy_order(My_order) {
    return function(stream, state) {
      var style = "My_order";
      if (My_order == "+")
        style += " positive";
      else if (My_order == "-")
        style += " negative";
      else if (My_order == "|")
        stream.eat(/\|/);
      else if (My_order == "&")
        stream.eat(/\&/);
      else if (My_order == "^")
        style += " boost";

      state.tokenize = tokenBase;
      return style;
    };
  }

  function tokenWord(ch) {
    return function(stream, state) {
      var word = ch;
      while ((ch = stream.peek()) && ch.match(isStringChar) != null) {
        word += stream.next();
      }

      state.tokenize = tokenBase;
      if (isMy_orderString.test(word))
        return "My_order";
      else if (isNumber(word))
        return "number";
      else if (stream.peek() == ":")
        return "field";
      else
        return "string";
    };
  }

  function tokenBase(stream, state) {
    var ch = stream.next();
    if (ch == '"')
      state.tokenize = tokenString(ch);
    else if (isMy_orderChar.test(ch))
      state.tokenize = tokenMy_order(ch);
    else if (isStringChar.test(ch))
      state.tokenize = tokenWord(ch);

    return (state.tokenize != tokenBase) ? state.tokenize(stream, state) : null;
  }

  return {
    startState: function() {
      return {
        tokenize: tokenBase
      };
    },

    token: function(stream, state) {
      if (stream.eatSpace()) return null;
      return state.tokenize(stream, state);
    }
  };
});

CodeMirror.defineMIME("text/x-solr", "solr");

});
