# Cisco Packet Tracer Networking Lab

A complete Cisco Packet Tracer networking lab covering IP addressing, connectivity, static routing, SSH, Telnet, and switch port security.

## Network Topology

The network consists of:

- **HQ**

  - Admin-PC
  - Staff-PC
  - R1-HQ
  - S1

- **Branch**

  - Branch-Laptop
  - R2-Branch

R1-HQ and R2-Branch are connected through a WAN link.

## IP Addressing

| Device        | Interface | IP Address    | Subnet Mask   | Default Gateway |
| ------------- | --------- | ------------- | ------------- | --------------- |
| R1-HQ         | Fa0/0     | 192.168.10.1  | 255.255.255.0 | —               |
| R1-HQ         | Fa0/1     | 10.0.0.1      | 255.0.0.0     | —               |
| R2-Branch     | Fa0/0     | 10.0.0.2      | 255.0.0.0     | —               |
| R2-Branch     | Fa0/1     | 192.168.20.1  | 255.255.255.0 | —               |
| Admin-PC      | —         | 192.168.10.10 | 255.255.255.0 | 192.168.10.1    |
| Staff-PC      | —         | 192.168.10.20 | 255.255.255.0 | 192.168.10.1    |
| Branch-Laptop | —         | 192.168.20.10 | 255.255.255.0 | 192.168.20.1    |

---

# Task 1 — Basic Connectivity

## R1-HQ Configuration

```text
enable
configure terminal
hostname R1-HQ

interface fastethernet 0/0
ip address 192.168.10.1 255.255.255.0
no shutdown
exit

interface fastethernet 0/1
ip address 10.0.0.1 255.0.0.0
no shutdown
exit

end
write memory
```

## R2-Branch Configuration

```text
enable
configure terminal
hostname R2-Branch

interface fastethernet 0/0
ip address 10.0.0.2 255.0.0.0
no shutdown
exit

interface fastethernet 0/1
ip address 192.168.20.1 255.255.255.0
no shutdown
exit

end
write memory
```

## Connectivity Tests

From Staff-PC:

```text
ping 192.168.10.1
```

From Branch-Laptop:

```text
ping 192.168.20.1
```

Both tests were successful.

---

# Task 2 — Static Routing

## R1-HQ

A static route was added to reach the Branch network through R2-Branch.

```text
enable
configure terminal
ip route 192.168.20.0 255.255.255.0 10.0.0.2
end
write memory
```

## R2-Branch

A default route was added toward R1-HQ.

```text
enable
configure terminal
ip route 0.0.0.0 0.0.0.0 fastethernet 0/0
end
write memory
```

## Routing Tests

From R1-HQ:

```text
ping 10.0.0.2
ping 192.168.20.1
ping 192.168.20.10
```

A Simple PDU test was also performed from:

**Admin-PC → Branch-Laptop**

The PDU was successful.

---

# Task 3 — SSH and Telnet

## SSH Configuration on R1-HQ

```text
enable
configure terminal

hostname R1-HQ
ip domain-name lab.local
username admin privilege 15 secret Cisco123!

crypto key generate rsa
```

When asked for the modulus, the value used was:

```text
1024
```

Then:

```text
ip ssh version 2

line vty 0 4
login local
transport input ssh
exit

end
write memory
```

## SSH Test

From Admin-PC:

```text
ssh -l admin 192.168.10.1
```

Password:

```text
Cisco123!
```

SSH connection was successful.

## Telnet Test on R1-HQ

```text
telnet 192.168.10.1
```

The connection failed because Telnet access was not allowed on R1-HQ.

---

## Telnet Configuration on R2-Branch

```text
enable
configure terminal

line vty 0 4
password cisco
login
transport input telnet
exit

end
write memory
```

## Telnet Test

From Admin-PC:

```text
telnet 10.0.0.2
```

Password:

```text
cisco
```

Telnet connection was successful.

---

# Task 4 — Port Security

Port Security was configured on **S1 Fa0/1**, which is connected to Admin-PC.

## S1 Configuration

```text
enable
configure terminal

hostname S1

interface fastethernet 0/1
switchport mode access
switchport port-security
switchport port-security maximum 1
switchport port-security mac-address sticky
switchport port-security violation shutdown

end
write memory
```

## Verification

```text
show port-security interface fa0/1
```

The port security configuration was enabled and the Admin-PC MAC address was learned using sticky MAC.

## Port Security Test

Admin-PC was disconnected and an unauthorized device was connected to the same port.

The unauthorized device attempted to ping the gateway:

```text
ping 192.168.10.1
```

The ping failed because the device had a different MAC address.

The switch detected the violation and the port was shut down.

The link light changed to red.

## Restoring the Port

The port was manually restored using:

```text
enable
configure terminal

interface fastethernet 0/1
shutdown
no shutdown

end
```

The link returned to green after the port was enabled again.

---

# Results

All required tasks were completed:

- Basic connectivity tested successfully.
- Static routing configured successfully.
- Admin-PC successfully connected to R1-HQ using SSH.
- Telnet to R1-HQ was blocked.
- Admin-PC successfully connected to R2-Branch using Telnet.
- Port Security was configured and tested.
- Unauthorized MAC address caused the port to shut down.
- The port was manually restored successfully.

## Technologies Used

- Cisco Packet Tracer
- IPv4
- Static Routing
- SSH
- Telnet
- Port Security
- Sticky MAC Address
- Ping
- Simple PDU


