var SuccesModalPage = function() {};

SuccesModalPage.prototype = Object.create({}, {

    //Modal koji se pojavljuje u gornjem desnom uglu za uspešno dodavanje
    succesModalAppears: {
        get: function() {
            return element(by.xpath('//div[@class="ui-pnotify-text"]'));
        }
    },

    //Dugme pause na Modalu
    pauseBtn: {
        get: function() {
            return element(by.xpath('//span[@class="fa fa-pause"]'));
        }
    },

    //Dugme play  
    playBtn: {
        get: function() {
            return element(by.xpath('//span[@class="fa fa-play"]'));
        }
    },

    //Dugme X 
    xBtn: {
        get: function() {
            return element(by.xpath('//span[@class="fa fa-times"]'));
        }
    }

});

module.exports = SuccesModalPage;