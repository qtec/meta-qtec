DESCRIPTION = "Jupyter Python Launcher"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.0;md5=9427b8ccf5cf3df47c29110424c9641a"

RDEPENDS_${PN} += "bash python3-jupyter-client python3-ipykernel python3-notebook sudo"

SRC_URI = "\
		file://notebook\
		file://notebook.default\
	 "

S = "${WORKDIR}"

inherit update-rc.d useradd

do_install(){
	install -d ${D}${sysconfdir}/init.d/
	install -m 755 ${WORKDIR}/notebook ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/default/
	install -m 644 notebook.default  ${D}${sysconfdir}/default/notebook
}

INITSCRIPT_NAME = "notebook"
INITSCRIPT_PARAMS = "start 98 5 2 . stop 20 0 1 6 ."

CONFFILES_${PN} += "${sysconfdir}/default/notebook"

#Create a passwordless user
USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--create-home \
                       --password \"\" \
                       --groups video,tty \
                       --user-group qtec"
