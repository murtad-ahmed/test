import speedtest
import requests
import socket
import platform
from datetime import datetime
import subprocess

# Get WiFi Name
def get_wifi_name():
    try:
        result = subprocess.check_output(
            "powershell (Get-NetConnectionProfile).Name",
            shell=True,
            text=True
        )
        return result.strip()
    except:
        return "Unknown"


# Get Network Information
wifi_name = get_wifi_name()
computer_name = socket.gethostname()

try:
    local_ip = socket.gethostbyname(computer_name)
except:
    local_ip = "Unknown"

try:
    info = requests.get(
        "https://ipinfo.io/json",
        timeout=10
    ).json()

    public_ip = info.get("ip", "Unknown")
    isp = info.get("org", "Unknown")
    city = info.get("city", "Unknown")
    country = info.get("country", "Unknown")

except:
    public_ip = "Unknown"
    isp = "Unknown"
    city = "Unknown"
    country = "Unknown"


print("=" * 60)
print("ADVANCED INTERNET SPEED TEST")
print("=" * 60)

print(f"Network Name : {wifi_name}")
print(f"Computer Name: {computer_name}")
print(f"Operating Sys: {platform.system()} {platform.release()}")
print(f"Local IP     : {local_ip}")
print(f"Public IP    : {public_ip}")
print(f"ISP          : {isp}")
print(f"Location     : {city}, {country}")

print("\nTesting internet speed...\n")

try:
    st = speedtest.Speedtest(secure=True)

    st.get_best_server()

    download = st.download() / 1_000_000
    upload = st.upload() / 1_000_000
    ping = st.results.ping

    print("=" * 60)
    print("SPEED TEST RESULTS")
    print("=" * 60)

    print(f"Download Speed : {download:.2f} Mbps")
    print(f"Upload Speed   : {upload:.2f} Mbps")
    print(f"Ping           : {ping:.2f} ms")

    now = datetime.now().strftime("%Y-%m-%d %H:%M:%S")

    report = f"""
=========================================
ADVANCED INTERNET SPEED TEST REPORT
=========================================
Date            : {now}
Network Name    : {wifi_name}
Computer Name   : {computer_name}
Operating System: {platform.system()} {platform.release()}

Local IP        : {local_ip}
Public IP       : {public_ip}

ISP             : {isp}
Location        : {city}, {country}

Download Speed  : {download:.2f} Mbps
Upload Speed    : {upload:.2f} Mbps
Ping            : {ping:.2f} ms
=========================================
"""

    with open("speed_report.txt", "w", encoding="utf-8") as f:
        f.write(report)

    print("\nReport saved as speed_report.txt")

except Exception as e:
    print("Speed Test Error:")
    print(e)

input("\nPress Enter to exit...")