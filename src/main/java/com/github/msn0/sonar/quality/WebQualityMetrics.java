package com.github.msn0.sonar.quality;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.Arrays;
import java.util.List;

public final class WebQualityMetrics implements Metrics {

    public static final Metric SCORE = new Metric.Builder("score", "PSI Score", Metric.ValueType.INT)
            .setDescription("PageSpeed Insights (PSI)")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(true)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .setBestValue(100d)
            .setWorstValue(0d)
            .create();

    public static final Metric HTML_RESPONSE_BYTES = new Metric.Builder("html-response", "HTML response size in kB", Metric.ValueType.FLOAT)
            .setDescription("HTML response size in kB")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric CSS_RESPONSE_BYTES = new Metric.Builder("css-response", "CSS response size in kB", Metric.ValueType.FLOAT)
            .setDescription("CSS response size in kB")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric JAVASCRIPT_RESPONSE_BYTES = new Metric.Builder("javascript-response", "Javascript response size in kB", Metric.ValueType.FLOAT)
            .setDescription("Javascript response size in kB")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric IMAGE_RESPONSE_BYTES = new Metric.Builder("image-response-bytes", "Image response bytes", Metric.ValueType.INT)
            .setDescription("Image response bytes")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(true)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric OTHER_RESPONSE_BYTES = new Metric.Builder("other-response-bytes", "Other response bytes", Metric.ValueType.INT)
            .setDescription("Other response bytes")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(true)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric TOTAL_REQUEST_BYTES = new Metric.Builder("total-request-bytes", "Total request bytes", Metric.ValueType.INT)
            .setDescription("Total request bytes")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(true)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric NUMBER_RESOURCES = new Metric.Builder("number-resources", "Number of resources", Metric.ValueType.INT)
            .setDescription("Number of resources")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(true)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric NUMBER_HOSTS = new Metric.Builder("number-hosts", "Number of hosts", Metric.ValueType.INT)
            .setDescription("Number of hosts")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(true)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric NUMBER_STATIC_RESOURCES = new Metric.Builder("number-static-resources", "Number of static resources", Metric.ValueType.INT)
            .setDescription("Number of static resources")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(true)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric NUMBER_JS_RESOURCES = new Metric.Builder("number-js-resources", "Number of js resources", Metric.ValueType.INT)
            .setDescription("Number of js resources")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(true)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric NUMBER_CSS_RESOURCES = new Metric.Builder("number-css-resources", "Number of css resources", Metric.ValueType.INT)
            .setDescription("Number of css resources")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(true)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public List<Metric> getMetrics() {
        return Arrays.asList(
                SCORE,
                HTML_RESPONSE_BYTES,
                CSS_RESPONSE_BYTES,
                JAVASCRIPT_RESPONSE_BYTES,
                NUMBER_RESOURCES,
                NUMBER_HOSTS,
                NUMBER_STATIC_RESOURCES,
                IMAGE_RESPONSE_BYTES,
                OTHER_RESPONSE_BYTES,
                TOTAL_REQUEST_BYTES,
                NUMBER_JS_RESOURCES,
                NUMBER_CSS_RESOURCES
        );
    }
}
