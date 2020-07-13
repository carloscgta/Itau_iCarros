(function($) {
  function getData(el) {
    var curr = [];
    el.children('li, ul').each(function(i, child) {
      curr.push({
        nodeName: child.nodeName,
        nome: $(child).find("> span").text(),
        cargo: $(child).find("> strong").text(),
        subLevel: getData($(child))
      });
    });
    return curr
  }

  var result = getData($('.root'));
  console.log(JSON.stringify(result));

})(jQuery);