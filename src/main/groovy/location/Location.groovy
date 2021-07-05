package location

import grails.rest.Resource


@Resource(uri = '/locations', formats = ['json', 'xml', 'csv'])
class Location {
    String name = ""
    String city = ""
    String zip = ""
    String streetAndStreetNo = ""
    List<OpeningHour> openingHours = new ArrayList<>()
    List<String> keywords = new ArrayList<>()
    Double lat
    Double lng

    @Override
    String toString() {
        return name + ',' + city + ',' + zip + "," + streetAndStreetNo + "," +
                keywords.join("|") + "," + lat + "," + lng + "," + openingHours.join(",")
    }
}
