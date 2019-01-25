var TwitterPackage = require('twitter');

var secret = {
  consumer_key: 'nYwCyXWfVNXlohfVKKme4U6qR',
  consumer_secret: 'kyvQDl1nDoLGWQ6PpNUdGjkaE56CPKgUBNjIZjHjutBLqqsNBL',
  access_token_key: '1088307923221209094-Yaw16JInJmk1YdqtCm0EiF2FbMxC83',
  access_token_secret: '1IDAnpTeTjFoQ1F3wLNWxamIxRXy1uFialIyV8TvYuwUe'
}
var Twitter = new TwitterPackage(secret);

//TWITTER STREAMING API
//-TWITTER.stream-//
// Call the stream function and pass in 'statuses/filter', our filter object, and our callback
Twitter.stream('statuses/filter', {track: '#futuride'}, function(stream) {
  // when data is recieved
  stream.on('data', function(tweet) {
    // print out the text of the tweet that came in
    //console.log(tweet.text);
    //build our reply object
    var statusObj = {status: "Hi @" + tweet.user.screen_name + ", you can visit the FUTURiDE site for more info on us!"}
    //call the post function to tweet something
    Twitter.post('statuses/update', statusObj,  function(error, tweetReply, response){
      //if we get an error print it out
      if(error){
        console.log(error);
      }
      //print the text of the tweet we sent out
      //console.log(tweetReply.text);
    });
  });
  // ... when we get an error...
  stream.on('error', function(error) {
    //print out the error
    console.log(error);
  });
});


//Automatically retweet a hashtag on an interval
const retweetByStatus = (status, callback) => {
  let id = status.id_str;
  console.log(`DEBUG: id_str: ${id}`);

  Twitter.post(`statuses/retweet/${id}`, (err, tweet) => {
    if (err) {
      console.error(err);
      return callback(err);
    }
    callback(null, tweet);
  });
}

/**
 * callback(err, retweetArray)
 */
const retweetAllFromStatusArray = (statusArray, callback) => {
  if (statusArray.length === 0) {
    console.log(`DEBUG: no statuses in array`)
    return callback(null, []);
  }

  let retweetArray = [];
  statusArray.forEach((status) => {
    retweetByStatus(status, (err, tweet) => {
      if (err) {
        console.error(err);
        console.log(`DEBUG: tweet = ${err}`);
        retweetArray.push(err);
      } else {
        console.log(`DEBUG: tweet = ${JSON.stringify(tweet, null, '  ')}`);
        retweetArray.push(tweet);
      }
      // are all retweets accounted for?
      if (retweetArray.length === statusArray.length) {
        // if so, we're done and ready for the callback
        callback(null, retweetArray);
      }
    })
  })
}

const getandrepostQu = (callback) => {
  Twitter.get('search/tweets', { q: 'car deals', result_type: 'recent', lang: 'en', count: 2 }, (err, data) => {
    if (err) {
      console.error(err);
      return callback(err);
    }
    retweetAllFromStatusArray(data.statuses, callback);
  });
}

(function recurse(){
  getandrepostQu((err, retweets) => {
    if (err) {
      console.error(err);
    } else {
      console.log(`DEBUG: retweets = ${JSON.stringify(retweets, null, '  ')}`);
    }
    setTimeout(recurse, 6000);
  })
})();
