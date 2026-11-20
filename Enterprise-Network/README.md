# Enterprise Network Design and Implementation

A Cisco Packet Tracer project that simulates a company network connecting a Headquarters (HQ) and a Branch Office through an ISP router.

## Project File

- `Enterprise_Network_Project.pkt` — Cisco Packet Tracer network simulation

Download the `.pkt` file and open it with Cisco Packet Tracer.

## Network Topology

The network includes:

- Three Cisco 1841 routers: HQ, ISP, and Branch
- Two switches: HQ Switch and Branch Switch
- Three servers: DHCP/DNS, Web, and FTP
- Client PCs at HQ and the Branch
- Serial WAN links between HQ–ISP and ISP–Branch
- VLAN separation at HQ for Administration and Servers

`text
HQ Administration ─┐
                    ├─ HQ Switch ─ HQ Router ─ ISP Router ─ Branch Router ─ Branch Switch ─ Branch PCs
HQ Servers ─────────┘
`

IP Addressing Plan
The three LAN networks use /26 subnets. The point-to-point WAN links use /30 subnets.
Network	Subnet	Gateway / Interface
HQ Administration, VLAN 10	10.10.0.0/26	10.10.0.1
HQ Servers, VLAN 20	10.10.0.64/26	10.10.0.65
Branch LAN	10.10.0.128/26	10.10.0.129
HQ–ISP WAN	10.10.0.192/30	ISP: 10.10.0.193, HQ: 10.10.0.194
ISP–Branch WAN	10.10.0.196/30	ISP: 10.10.0.197, Branch: 10.10.0.198


Subnet mask for LANs: 255.255.255.192
Subnet mask for WAN links: 255.255.255.252
VLAN Configuration
VLAN	Name	Network	Gateway
10	Administration	10.10.0.0/26	10.10.0.1
20	Servers	10.10.0.64/26	10.10.0.65


The HQ router provides inter-VLAN routing using 802.1Q subinterfaces. The link between the HQ router and HQ switch is configured as a trunk.
Network Services
DHCP
A centralized DHCP service runs on the HQ DHCP/DNS server.
- HQ_ADMIN pool assigns addresses to HQ Administration clients.
- BRANCH pool assigns addresses to Branch clients.
- DHCP relay is configured on the client-facing router interfaces.
DNS
The HQ DHCP/DNS server provides these records:
Hostname	Address
portal.company.local	10.10.0.67
ftp.company.local	10.10.0.68


Web Server
- Static address: 10.10.0.67
- HTTP is enabled.
- The organizational homepage is available at http://portal.company.local.
FTP Server
- Static address: 10.10.0.68
- FTP service is enabled with a lab user account.
- The test file was uploaded from HQ and downloaded from the Branch.
Routing
OSPF is configured on the HQ, ISP, and Branch routers to advertise the LAN and WAN networks.
Verification
The following checks were completed in Packet Tracer:
- DHCP address assignment for clients
- DNS name resolution for the Web and FTP servers
- Web access from HQ and Branch clients
- FTP login, file upload, and file download
- Inter-VLAN connectivity between HQ Administration and the server network
- OSPF neighbor and learned-route checks
- Connectivity from the HQ router to the Branch LAN gateway
Notes
This project is an educational network simulation built with Cisco Packet Tracer. The FTP account is for lab use only and is not intended for production.
