var IstrazivaciProjekatPage = function() {}

IstrazivaciProjekatPage.prototype = Object.create({}, {


    tipOsobe: {
        get: function() {
            return element(by.model("data.bibliography"));
        },
        set: function(value) {
            this.tipOsobe.clear();
            this.tipOsobe.sendKeys(value);
        }
    },

    // Error msg.
    tipOsobeError: {
        get : function() {
            return element(by.xpath("//div[@title=\"Tip osobe *\"]//span"));
        }
    },

    // Buttons
    odustaniBtn: {
        get: function() {
            return element(by.xpath("//button [@ng-click='reset()']"));
        }
    },

    sacuvajBtn: {
        get: function() {
            return element(by.xpath("//button [@ng-click='addctrl.savePerson(Project)']"));
        }
    }
    

});

module.exports = IstrazivaciProjekatPage;
