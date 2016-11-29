SUMMARY = "S3TC with DRI drivers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://txc_dxtn.h;endline=23;md5=17a9bd3fad02dfacc9c13d85deb6a16c"

DEPENDS = "virtual/libgl"

SRC_URI = "https://people.freedesktop.org/~cbrill/libtxc_dxtn/libtxc_dxtn-1.0.1.tar.bz2"
SRC_URI[md5sum] = "7105107f07ac49753f4b61ba9d0c79c5"
SRC_URI[sha256sum] = "45290d12cdca529a3f41e7fc35c4250fc1b6d2fc16b56680f8401f6aa792ae60"

S="${WORKDIR}/libtxc_dxtn-${PV}"

FILES_${PN} += "${libdir}/libtxc_dxtn.so"
FILES_${PN}-dev = "${libdir}/libtxc_dxtn.la ${includedir}"

inherit autotools
