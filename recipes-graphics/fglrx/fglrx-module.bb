SECTION = "kernel"
SUMMARY = "FGLRX driver"
DESCRIPTION = "The FGLRX driver contains the proprietary kernel module for ATI/AMD cards"
LICENSE = "Proprietary"

DEPENDS += "virtual/kernel"

require amd-source.inc

SRC_URI += "	file://Makefile.patch \
		file://build_4.3_crimson.patch \
		file://build_4.4_crimson.patch \
		file://build_4.5_crimson.patch \
		file://build_4.6_crimson.patch \
		file://small-alloc-atomic.patch \
		file://pat_pge.patch \
		file://license.patch"

inherit module

do_compile_prepend(){
	cp arch/x86${@bb.utils.contains("TARGET_ARCH", "x86_64", "_64", "", d)}/lib/modules/fglrx/build_mod/libfglrx_ip.a common/lib/modules/fglrx/build_mod/
	cd common/lib/modules/fglrx/build_mod/
	cp 2.6.x/Makefile .
}

do_install_prepend(){
	install -d ${D}${sysconfdir}/modprobe.d
	echo "blacklist radeon" > ${D}${sysconfdir}/modprobe.d/fglrx.conf
	cd common/lib/modules/fglrx/build_mod/
}
