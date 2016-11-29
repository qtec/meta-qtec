PACKAGES =+ "util-linux-dmesg"
FILES_util-linux-dmesg = "${base_bindir}/dmesg.${BPN}"

ALTERNATIVE_${PN}_remove = "dmesg"
ALTERNATIVE_util-linux-dmesg = "dmesg"

