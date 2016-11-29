FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_qt5022-fglrx += "\
				file://xorg.conf.discrete\
				file://xorg.conf.intel\
				"

SRC_URI_append += "\
				file://xorg.conf.intel\
				"

do_install_append(){
	install -m 0644 ${WORKDIR}/xorg.conf.intel ${D}/${sysconfdir}/X11/
}

do_install_append_qt5022-fglrx(){
	install -m 0644 ${WORKDIR}/xorg.conf.discrete ${D}/${sysconfdir}/X11/
	install -m 0644 ${WORKDIR}/xorg.conf.intel ${D}/${sysconfdir}/X11/
}
