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

    public static final Metric HTML_SIZE = new Metric.Builder("html-size", "HTML size in kB", Metric.ValueType.FLOAT)
            .setDescription("HTML size in kB")
            .setDirection(Metric.DIRECTION_WORST)
            .setQualitative(false)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public List<Metric> getMetrics() {
        return Arrays.asList(SCORE, HTML_SIZE);
    }
}