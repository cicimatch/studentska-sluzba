var Jasmine2HtmlReporter = require('protractor-jasmine2-html-reporter');
var SpecReporter = require('jasmine-spec-reporter');

exports.config = {
    seleniumServerJar: '../../../node_modules/protractor/selenium/selenium-server-standalone-2.47.1.jar',
    chromeDriver: '../../../node_modules/protractor/selenium/chromedriver',
    allScriptsTimeout: 20000,

    specs: [
        // Primeri se mogu pokrenuti svi zajedno
        //'e2e/specs/testLogin.spec.js',
        //'e2e/specs/testAddIstrazivaca.spec.js',
        //'e2e/specs/testPodaciZaRegistar.spec.js',
        'e2e/specs/testPodaciZaProjekte.spec.js',
        //'e2e/specs/testAddAngazovanja.spec.js'
    ],

    capabilities: {
        'browserName': 'chrome',
    },

    directConnect: true,

    baseUrl: 'http://park.ftn.uns.ac.rs:8080/#/',

    framework: 'jasmine2',

    jasmineNodeOpts: {
        showColors: true,
        isVerbose: true,
        defaultTimeoutInterval: 30000,
        print: function() {}
    },

    onPrepare: function() {
        // Postavljamo prozor na fullscreen
        browser.driver.manage().window().maximize();
        
        // Registrujemo reportere
        jasmine.getEnv().addReporter(new Jasmine2HtmlReporter({
            savePath: "./target/reports/e2e/",
            takeScreenshots: true,
            takeScreenshotsOnlyOnFailures: true,
            fixedScreenshotName: true
        }));
        jasmine.getEnv().addReporter(new SpecReporter({
            displayStacktrace: 'all',
            displaySpecDuration: true, 
            displayFailuresSummary: false, 
            displayPendingSummary: false,  
        }));
    }
};
