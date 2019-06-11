package fr.positif.backend;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bfrolin
 */
public abstract class AbstractSerializer {
    
    protected PrintWriter getWriterWithJsonHeader(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        return out;
    }
    
    public abstract void serialize(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
