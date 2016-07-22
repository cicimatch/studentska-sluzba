var GornjiMenu = function() {};

GornjiMenu.prototype = Object.create({}, {

    //grb (u njoj se nalazi button za odjavu, koji nam je bitan kasnije)
    grb: {
        get: function() {
            return element(by.xpath("//a[@class='dropdown-toggle']"));
        }
    },

    odjava: {
        get: function() {
            return element(by.xpath("//span[@translate='LOGOUT']"));
        }
    },

    //menu-bar sa leve strane
    institucijeBtn: {
        get: function() {
            return element(by.xpath("//li[@title='Institucija']"));
            //return element(by.xpath('//*[@id="main-page"]/aside/section/ul/li[3]/a/i'));
        }
    }, 

     //preko id-a selector, mada ni-na-šta mi ne liči
     //na kraju i ne radi
    istrazivaciBtn: {
        get: function() {
             return element(by.xpath("//li[@title='Istraživači']"));
            //return element(by.xpath('//*[@id="main-page"]/aside/section/ul/li[4]/a/i'));
        }
    },
    
    //Podmeni za menjanje jezika (tamo kod grba)
    jezik: {
        get: function() {
            return element(by.className('caret'));
        }
    },

    srpskiLat: {
        get: function() {
            return element(by.linkText("Srpski"));
        }
    },

    srpskiCir: {
        get: function() {
            return element(by.linkText("Српски"));
        }
    },

    engleski: {
        get: function() {
            return element(by.linkText("English"));
        }
    },

    menuMinis: {
        get: function() {
            return element.all(by.xpath('//ul[@class="nav nav-tabs"]/li'));
        }
    },

    osnovniPodaci: {
        get: function() {
            return element(by.xpath('//ul[@class="nav nav-tabs"]/li[1]'));
        }
    },

    podaciZaRegistar: {
        get: function() {
            return element(by.xpath("//ul[@class='nav nav-tabs']/li[2]"));
        }
    },

    podaciZaProjekte: {
        get: function() {
            return element(by.xpath('//ul[@class="nav nav-tabs"]/li[3]'));
        }
    },
    
    istrazivaciTab: {
        get: function() {
            return element(by.xpath('//ul[@class="nav nav-tabs"]/li[4]'));
        }
    }
    


});

module.exports = GornjiMenu;