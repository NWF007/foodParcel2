//Danielle Johnson
//Student no: 214104281

package com.foodparcel.Repository.impl;
import org.junit.Test;
import org.junit.Assert;

import com.foodparcel.Repository.ApplicationRepository;
import com.foodparcel.entity.Application;
import com.foodparcel.factory.ApplicationFactory;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import java.util.UUID;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApplicationRepositoryImplTest {

    private static ApplicationRepository repository = ApplicationRepositoryImpl.getRepository();
    //application 1
    private static Application application = ApplicationFactory.createApplication("5656675", "FHGkjhsdkj",
            "Johnson", "090678456", "17 Krisnic",
            2, 5600.00);

    @Test
    public void aCreate() {
        //application1
        Application createAppl = repository.create(application);
        assertEquals(application.getId(), createAppl.getId());
        System.out.println("Application created : " + createAppl);

    }

    @Test
    public void bRead() {
        Application readApplication = repository.read(application.getId());
        System.out.println("Read Application : " + readApplication);

    }

    @Test
    public void cUpdate() {

        //application 1 : Update First Name
        Application updateApplication = new Application.Builder().copy(application).setfirstName("Danielle").build();
        updateApplication = repository.update(updateApplication);
        System.out.println("Application updated : " + updateApplication);

    }
    @Test
    public void d_GetAll() {
        System.out.println("Get application" + repository.getAll());
    }

    @Test
    public void e_delete() {
        //application 1
        repository.delete(application.getId());
        System.out.println("Application deleted");


    }

}