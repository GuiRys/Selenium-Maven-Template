Selenium-Maven-Template
=======================

A maven template for Selenium 3 that has the latest dependencies so that you can just check out and start writing tests in four easy steps.

### Requirements

* Java
* Maven
* docker : https://www.docker.com/
* docker-composer (>= 1.8.x) : https://docs.docker.com/compose/install/

### Clone project

```bash
git clone git@github.com:GuiRys/Selenium-Maven-Template.git
```

### Start docker selenium server
1. Open a terminal window/command prompt
2. `cd Selenium-Maven-Template` (Or whatever folder you cloned it into)
3. `docker-composer -f docker-compose-selenium up`

### Start test
1. Open a terminal window/command prompt
3. `cd Selenium-Maven-Template` (Or whatever folder you cloned it into)
4. `mvn clean verify -Dremote=true -DseleniumGridURL=http://localhost:4444/wd/hub -Dbrowser=chrome`

All dependencies should now be downloaded and the test will run automatically in a docker container in a chrome browser

### How to see the test running ?

You can see the tests rolling while they're being executed.
For that you need a VNC client.

Chrome node
* host : vnc://127.0.0.1:5901
* password : secret

Chrome node
* host : vnc://127.0.0.1:5902
* password : secret

### What should I know?

- To run any unit tests that test your Selenium framework you just need to ensure that all unit test file names end, or start with "test" and they will be run as part of the build.
- The maven failsafe plugin has been used to create a profile with the id "selenium-tests".  This is active by default, but if you want to perform a build without running your selenium tests you can disable it using:

        mvn clean verify -P-selenium-tests

- The maven-failsafe-plugin will pick up any files that end in IT by default.  You can customise this is you would prefer to use a custom identifier for your Selenium tests.

### Known problems...

- It looks like SafariDriver is no longer playing nicely and we are waiting on Apple to fix it... Running safari driver locally in server mode and connecting to it like a grid seems to be the workaround.

### Anything else?

Yes you can specify which browser to use by using one of the following switches:

- -Dbrowser=firefox
- -Dbrowser=chrome
- -Dbrowser=ie
- -Dbrowser=edge
- -Dbrowser=opera

If you want to toggle the use of chrome or firefox in headless mode set the headless flag (by default the headless flag is set to true)

- -Dheadless=true
- -Dheadless=false

You don't need to worry about downloading the IEDriverServer, EdgeDriver, ChromeDriver , OperaChromiumDriver, or GeckoDriver binaries, this project will do that for you automatically.

You can specify a grid to connect to where you can choose your browser, browser version and platform:

- -Dremote=true
- -DseleniumGridURL=http://{username}:{accessKey}@ondemand.saucelabs.com:80/wd/hub
- -Dplatform=xp
- -Dbrowser=firefox
- -DbrowserVersion=44

You can even specify multiple threads (you can do it on a grid as well!):

- -Dthreads=2

You can also specify a proxy to use

- -DproxyEnabled=true
- -DproxyHost=localhost
- -DproxyPort=8080

If the tests fail screenshots will be saved in ${project.basedir}/target/screenshots

If you need to force a binary overwrite you can do:

- -Doverwrite.binaries=true

### It's not working!!!

You have probably got outdated driver binaries, by default they are not overwritten if they already exist to speed things up.  You have two options:

- `mvn clean verify -Doverwrite.binaries=true`
- Delete the `selenium_standalone_binaries` folder in your resources directory
