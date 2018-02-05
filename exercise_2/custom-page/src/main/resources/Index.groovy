import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.bonitasoft.console.common.server.page.PageContext
import org.bonitasoft.console.common.server.page.PageController
import org.bonitasoft.console.common.server.page.PageResourceProvider

class Index implements PageController {

    @Override
    void doGet(HttpServletRequest request, HttpServletResponse response, PageResourceProvider pageResourceProvider, PageContext pageContext) {
            String indexContent
        try {

            pageResourceProvider.getResourceAsStream("Index.groovy").withStream { InputStream s ->
                indexContent = s.getText()
            }
            response.setCharacterEncoding("UTF-8")
            PrintWriter out = response.getWriter()
            out.println("should get some content here")
        } catch (Exception e) {
            throw new RuntimeException(e)
        }
    }
}