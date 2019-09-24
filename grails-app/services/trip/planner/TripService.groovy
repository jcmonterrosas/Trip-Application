package trip.planner

import grails.gorm.services.Service

@Service(Trip)
interface TripService {

    Trip get(Serializable id)

    List<Trip> list(Map args)

    Long count()

    void delete(Serializable id)

    Trip save(Trip trip)

}