SUMMARY = "OpenCL ICD Loader"
DESCRIPTION = "OpenCL implementations are provided as ICD (Installable Client Driver). An OpenCL program can use several ICD thanks to the use of an ICD Loader as provided by this project. This free ICD Loader can load any (free or non free) ICD"
LICENSE = "other-MIT-style-KHRONOS"
PROVIDES = "virtual/opencl-icd"

SRC_URI = "https://forge.imag.fr/frs/download.php/716/ocl-icd-2.2.9.tar.gz"
SRC_URI[md5sum] = "7dab1a9531ea79c19a414a9ee229504e"
SRC_URI[sha256sum] = "0c8ac13e2c5b737c34de49f9aca6cad3c4d33dd0bbb149b01238d76e798feae5"

S = "${WORKDIR}/${PN}-${PV}"

LIC_FILES_CHKSUM = "file://COPYING;md5=232257bbf7320320725ca9529d3782ab"

inherit autotools
