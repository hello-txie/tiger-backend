// Resource (Controller) class
package org.tiger.controllers;

import org.tiger.entities.ScopeSubmission;
import org.tiger.services.ScopeSubmissionService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/form")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScopeSubmissionController {
    @Inject
    ScopeSubmissionService formSubmissionService;

    @POST
    @Transactional
    public Response submitForm(ScopeSubmission submission) {
        formSubmissionService.submitForm(submission);
        return Response.status(Response.Status.CREATED).entity(submission).build();
    }

    @GET
    public List<ScopeSubmission> getSubmissions() {
        return formSubmissionService.getAllSubmissions();
    }

    @GET
    @Path("/email")
    public List<ScopeSubmission> getSubmissionsByEmail(@QueryParam("email") String email) {
        return formSubmissionService.getSubmissionsByEmail(email);
    }
}