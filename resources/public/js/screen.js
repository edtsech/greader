$(document).ready(function() {
  var nav = $('#sidebar li');

  nav.find('a').click(function(event) {
    event.preventDefault();

    var link = $(this);

    var li = link.closest('li');
    var idx = $(nav).index(li);
    var section = $('#content h2').eq(idx);

    $('html, body').animate({scrollTop: section.offset().top}, function () {
      window.location.hash = link.attr('href');
    });
    return false;
  });
});
