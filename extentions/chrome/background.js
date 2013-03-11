chrome.browserAction.onClicked.addListener(function(tab) {
  chrome.tabs.create({'url': "http://grrrapp.herokuapp.com" + tab.url.replace('https://github.com', '')}, function(tab) {});
});