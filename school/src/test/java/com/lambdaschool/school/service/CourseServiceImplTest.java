package com.lambdaschool.school.service;


import com.lambdaschool.school.SchoolApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class CourseServiceImplTest
{

    @Autowired
    private CourseService courseService;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deleteFound()
    {
        // delete thing
        courseService.delete(1);
        // make sure we cant find thing anymore
        assertEquals(5, courseService.findAll().toArray().length);
    }

    @Test (expected = EntityNotFoundException.class)
    public void deleteNotFound()
    {
        // delete thing
        courseService.delete(2000);
        // make sure we cant find thing anymore
        assertEquals(5, courseService.findAll().toArray().length);
    }
}