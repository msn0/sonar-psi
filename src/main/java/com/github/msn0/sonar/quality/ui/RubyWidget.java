package com.github.msn0.sonar.quality.ui;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;
import org.sonar.api.web.WidgetCategory;

@UserRole(UserRole.USER)
@Description("Web Quality Widget")
@WidgetCategory("Web Quality")
public class RubyWidget extends AbstractRubyTemplate implements RubyRailsWidget {

    public String getId() {
        return "psi";
    }

    public String getTitle() {
        return "Page Speed Index (PSI) Widget";
    }

    @Override
    protected String getTemplatePath() {
        return "/views/widget.html.erb";
    }
}
