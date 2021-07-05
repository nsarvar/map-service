package uberall.backend.homework


import grails.plugin.cache.Cacheable
import location.Location
import location.LocationHttpClient
import location.LocationResult
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import org.springframework.beans.factory.annotation.Autowired

class LocationService {
    @Autowired
    LocationHttpClient locationClient

    @Cacheable('locationResults')
    List<Location> findAll(Integer max) {
        LocationResult result = locationClient.list(max)
        result.response.locations
    }

    String renderToCsv(List<Location> locations) {
        String[] header = ["name", "city", "zip", "streetAndStreetNo", "keywords", "lat", "lng",
                           "openingHoursDay1", "openingHoursDay2", "openingHoursDay3", "openingHoursDay4",
                           "openingHoursDay5", "openingHoursDay6", "openingHoursDay7"]
        def results = []
        results << header
        for (location in locations) {
            results << location
        }

        StringWriter stringWriter = new StringWriter();
        CSVPrinter printer = new CSVPrinter(stringWriter, CSVFormat.EXCEL);
        printer.printRecords(results)
        printer.flush()
        printer.close()
        return stringWriter.toString()
    }
}
