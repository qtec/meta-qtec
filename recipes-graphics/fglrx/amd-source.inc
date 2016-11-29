#For some reason amd keep playing with the version numbers...
PE = "2"
PV = "15.12"

SRC_URI[md5sum] = "39808c8a9bcc9041f1305e3531b60622"
SRC_URI[sha256sum] = "704f2dfc14681f76dae3b4120c87b1ded33cf43d5a1d800b6de5ca292bb61e58"

SRC_URI = "http://www2.ati.com/drivers/linux/radeon-crimson-15.12-15.302-151217a-297685e.zip"
S = "${WORKDIR}/fglrx-driver"

LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=fbbe964a4b211542cd2dfd1de0b01326"

do_unpack_amd(){
	sh ${WORKDIR}/fglrx-15.302/amd-driver-installer-15.302-x86.x86_64.run --extract ${WORKDIR}/fglrx-driver
	cp ${WORKDIR}/fglrx-driver/common/etc/ati/control ${WORKDIR}/control
}
addtask unpack_amd after do_unpack before do_patch

