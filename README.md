ScreenSteps Java Client
=======================

A Java client for the [ScreenSteps][ss] Rest Service, using Spring's RestTemplate.

Usage
-----

Create a 'ScreenSteps' instance, passing credentials and domain straight into the constructor. Then use the object to pull data from the various endpoints.

      ScreenSteps screenSteps = new ScreenSteps("user@email.com","password","example-domain");
      Manual manual = screenSteps.getManual("1234", "abcd");

A description of the available endpoints can be found [here][api].

Status
------

RC 0.9 released. All endpoints and models implemented. V1.0 to be release soon with minor re-factoring & optimizing.


[ss]: http://www.screensteps.com
[api]: http://help.screensteps.com/m/screenstepslive-api/pdf
