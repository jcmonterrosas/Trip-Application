package trip.planner

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TripServiceSpec extends Specification {

    TripService tripService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Trip(...).save(flush: true, failOnError: true)
        //new Trip(...).save(flush: true, failOnError: true)
        //Trip trip = new Trip(...).save(flush: true, failOnError: true)
        //new Trip(...).save(flush: true, failOnError: true)
        //new Trip(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //trip.id
    }

    void "test get"() {
        setupData()

        expect:
        tripService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Trip> tripList = tripService.list(max: 2, offset: 2)

        then:
        tripList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tripService.count() == 5
    }

    void "test delete"() {
        Long tripId = setupData()

        expect:
        tripService.count() == 5

        when:
        tripService.delete(tripId)
        sessionFactory.currentSession.flush()

        then:
        tripService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Trip trip = new Trip()
        tripService.save(trip)

        then:
        trip.id != null
    }
}
