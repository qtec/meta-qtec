DESCRIPTION = "v4l2 and IR applications"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=48da9957849056017dc568bbc43d8975\
                    file://COPYING.libv4l;md5=d749e86a105281d7a44c2328acebc4b0"

DEPENDS = "jpeg qt4-x11-free"
RDEPENDS_${PN} += "qt4-x11-free"

inherit autotools gettext pkgconfig

# libv4l was absorbed into this, let OE know that
PROVIDES = "libv4l"

SRC_URI = "git://github.com/qtec/v4l-utils.git;branch=qtec\
	file://cross-qt4.patch \
	"
SRCREV = "11c0382117e8ee34e41ec42ae1764cd65482ca57"

S = "${WORKDIR}/git"

do_configure_prepend(){
	rm -rf ${S}/build-aux
	mkdir ${S}/build-aux
	touch ${S}/build-aux/config.rpath ${S}/libdvbv5-po/Makefile.in.in ${S}/v4l-utils-po/Makefile.in.in
	(cd ${S}; gettextize --force --copy --no-changelog --po-dir=v4l-utils-po)
	(cd ${S}; gettextize --force --copy --no-changelog --po-dir=libdvbv5-po)
}

do_configure_append(){
}

EXTRA_OECONF = "--enable-shared  MOC=${STAGING_BINDIR_NATIVE}/moc4 RCC=${STAGING_BINDIR_NATIVE}/rcc4 UIC=${STAGING_BINDIR_NATIVE}/uic4"

PACKAGES =+ "rc-keymaps libv4l libv4l-dbg libv4l-dev qv4l2 qv4l2-dbg"

FILES_rc-keymaps = "${sysconfdir}/rc* ${base_libdir}/udev/rc*"
FILES_${PN} = "${bindir} ${sbindir} ${base_libdir}/udev/rules.d/70-infrared.rules /usr/share/ ${libdir}/libv4l/v4l1compat.so ${libdir}/libv4l/v4l2convert.so"
FILES_libv4l-dbg = "${libdir}/libv4l/.debug ${libdir}/libv4l/plugins/.debug ${libdir}/.debug"
FILES_libv4l-dev = "${includedir}/lib* ${libdir}/pkgconfig/lib* ${libdir}/libv4l/plugins/*.la ${libdir}/libv4l/*.la ${libdir}/v4l1compat.so ${libdir}/v4l2convert.so"
FILES_libv4l = "${libdir}/*.so.* ${libdir}/libv4l/*.so.* ${libdir}/libv4l/*.so.* ${libdir}/libv4l/ov* ${libdir}/libv4l/v4l2convert.so ${libdir}/libv4l/plugins/libv4l-mplane.so"
FILES_qv4l2 += "${bindir}/qv4l2 /usr/share/icons /usr/share/applications"
FILES_qv4l2-dbg += "${bindir}/.debug/qv4l2"
RDEPENDS_qv4l2 += "libicui18n"

