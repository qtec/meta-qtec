SRC_URI_append_class-native += " file://use-pixz.patch"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
RDEPENDS_${PN}_class-native += "pixz-native"
DEPENDS_class-native += "pixz-native"
