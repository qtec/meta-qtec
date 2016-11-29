FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_qt5022-open += "file://omxregister"

do_install_append_qt5022-open(){
	install -d  ${D}/home/root
	install -m 0644 ${WORKDIR}/omxregister ${D}/home/root/.omxregister
}

FILES_${PN}_append_qt5022-open += "/home/"
