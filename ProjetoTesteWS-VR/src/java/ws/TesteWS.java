/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.AlunoDAO;
import model.ClassAluno;
import model.ClassCurso;
import model.ClassDisciplina;
import model.CursoDAO;
import model.DisciplinaDAO;

/**
 * REST Web Service
 *
 * @author Otavio
 */
@Path("testeWS")
public class TesteWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TesteWS
     */
    public TesteWS() {
    }

    /**
     * Retrieves representation of an instance of ws.TesteWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ListaCurso")
    public String listCurso() throws SQLException {
        //TODO return proper representation object   
        CursoDAO dao = new CursoDAO();
        List<ClassCurso> lista = dao.read();
     
        Gson g = new Gson();
        return g.toJson(lista);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ListaAluno")
    public String listAluno() throws SQLException {
        //TODO return proper representation object   
        AlunoDAO dao = new AlunoDAO();
        List<ClassAluno> lista = dao.read();
     
        Gson g = new Gson();
        return g.toJson(lista);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ListaDisciplina")
    public String listDisciplina() throws SQLException {
        //TODO return proper representation object   
        DisciplinaDAO dao = new DisciplinaDAO();
        List<ClassDisciplina> lista = dao.read();
     
        Gson g = new Gson();
        return g.toJson(lista);
        
    }

    /**
     * PUT method for updating or creating an instance of TesteWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
