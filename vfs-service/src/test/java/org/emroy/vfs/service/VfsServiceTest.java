package org.emroy.vfs.service;
/*
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import vfs.VfsException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;



@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VfsServiceTest {

    public static Service vfsStore;

    @Deployment
    public static WebArchive createDeployment()
    {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage("org.emroy.vfs.service");

    }

    @ArquillianResource
    static URL url;


    @Before
    public void setupClass() throws MalformedURLException {

        vfsStore = Service.create(
                new URL(url, "VfsService?wsdl"),
                new QName("http://service.vfs.emroy.org/", "VfsServiceImpl"));
    }
    @Test
    public void testCreateDirectory() throws VfsException, MalformedURLException
    {

        VfsService store=vfsStore.getPort(VfsService.class);
        store.createDirectory("dir1");
    }

}

*/
