# sonar-psi

Sonar PageSpeed Insights plugin.

![PSI Plugin](screenshot.png)

## How to install?

```
mvn clean install
cp target/sonar-psi-0.1-SNAPSHOT.jar /path/to/sonarqube/extensions/plugins/
sonar restart
```

## How to use?

Plugin requires ``sonar.webquality.psi.report`` property set in ``sonar-project.properties`` 
file inside your project. For example:

```
sonar.webquality.psi.report=target/report-psi.json
```

You can generate ``report-psi.json`` using Google API:

```
wget -O target/report-psi.json "https://www.googleapis.com/pagespeedonline/v1/runPagespeed?url=http://your.website.url"
```