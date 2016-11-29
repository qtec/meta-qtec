DESCRIPTION = "Implementation of the library requirements of the OpenCL C programming language, as specified by the OpenCL 1.1 Specification"
HOMEPAGE = "http://libclc.llvm.org/"
LICENSE = "MIT & BSD"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=a1846fc6fdc2f642a7769cc79175be79"
DEPENDS += "clang-native"

SRCREV = "4ece2294c55ba1b993615d3bf0b0ec09e98deb3a"
SRC_URI = "git://llvm.org/git/libclc.git;protocol=http;nobranch=1"

S = "${WORKDIR}/git"

export STAGING_BINDIR_NATIVE
do_configure(){
	./configure.py --pkgconfigdir=${libdir}/pkgconfig --prefix=${prefix} --with-llvm-config=${STAGING_BINDIR_NATIVE}/llvm-config --with-cxx-compiler=g++
}

do_install(){
	make install DESTDIR=${D}
}

FILES_${PN} += "${libdir}/clc/ ${includedir}/clc/"
FILES_${PN}-dev = "${libdir}/pkgconfig/"
