package org.tucana.repository

import javax.inject.Inject
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.tucana.domain.Constellation

/**
 * Created by IntelliJ IDEA.
 * User: kamann
 * Date: 23.10.11
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */
@org.junit.runner.RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner)
@org.springframework.test.context.ContextConfiguration
@org.springframework.transaction.annotation.Transactional
class ConstellationRepositoryTest {

    @Inject
    ConstellationRepository repository

    @Before
    public void setup(){
        10.times {
            def c = new Constellation(area: 0, author: "author$it", authorYear: 2000, code: "c$it", genitiveName: "genN$it",
                    greatestMagnitude: 4.4, hemisphere: "N", name: "name$it", names: [], numberOfStarsGreater3M: 10,
                    numberOfStarsGreater4M: 3, starCardData: null, visibilityArea: 10)
            repository.save(c)
        }
    }

    @Test
    final void "test query all constellation objects"(){
        Assert.assertEquals(10, repository.findAll().size())
    }

    @Test
    final void "test query a constellation by its code"(){
        Assert.assertEquals("name3", repository.findByCode("c3").name)
    }
}
