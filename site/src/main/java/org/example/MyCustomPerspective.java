package org.example;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.hippoecm.frontend.plugin.IPluginContext;
import org.hippoecm.frontend.plugin.config.IPluginConfig;
import org.hippoecm.frontend.plugins.standards.perspective.Perspective;
import org.hippoecm.frontend.session.UserSession;

import javax.jcr.Session;

public class MyCustomPerspective extends Perspective {

    private static final ResourceReference PERSPECTIVE_CSS = new CssResourceReference(MyCustomPerspective.class, "MyCustomPerspective.css");

    public MyCustomPerspective(IPluginContext context, IPluginConfig config) {
        super(context, config);
        setOutputMarkupId(true);
        Session session = UserSession.get().getJcrSession();

    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(PERSPECTIVE_CSS));
    }
}
