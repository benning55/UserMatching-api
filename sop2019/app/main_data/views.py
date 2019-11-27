import urllib
import urllib.request
import json
import requests
from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view, permission_classes
from rest_framework.permissions import AllowAny
from main_data.serializers import PersonSerializer, RealPersonSerializer
from .models import RealPerson
from json import JSONEncoder
# Create your views here.


class MyEncoder(JSONEncoder):
    def default(self, o):
        return o.__dict__


@api_view(['POST', ])
@permission_classes([AllowAny, ])
def person_view(request):
    """To start recieving data"""
    if request.method == 'POST':
        serializer = PersonSerializer(data=request.data)
        if serializer.is_valid():
            result = serializer.create(validated_data=request.data)
            print(f'{result.first_name} {result.last_name}')
            # final_data = json.dumps(cls=MyEncoder, obj=result)
            data_a = get_company_a_data(result.first_name, result.last_name)
            data_b = get_company_b_data(result.first_name, result.last_name)
            payload = {
                'companyA': data_a,
                'companyB': data_b
            }
            sun_res = format_data(payload)
            print(sun_res)
            return Response(payload, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', ])
@permission_classes([AllowAny, ])
def companya_data(request):
    """Look at company a data"""
    url = "http://172.27.0.1:8200/companya/search-person/"
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    print("Test what is happen")
    payload = {
        "first_name": "ben",
        "last_name": "maisonti"
    }
    res = requests.post(url, json=payload, headers=headers)
    print(res.json())
    return Response(res.json(), status=status.HTTP_200_OK)


@api_view(['POST', ])
@permission_classes([AllowAny, ])
def result_data(request):
    """Recieve result data"""
    print("Benning")
    print("request", request.data)
    d1 = json.dumps(request.data)
    x = json.loads(d1)
    print("x", x)
    print(type(x))
    if request.method == 'POST':
        serializer = RealPersonSerializer(data=x)
        print("hello")
        if serializer.is_valid():
            jdata = x
            quryset = RealPerson.objects.all()
            if jdata['name']:
                quryset = quryset.filter(name=jdata['name'])
            if jdata['surname']:
                quryset = quryset.filter(surname=jdata['surname'])
            print("queryset", len(quryset.values()))
            if len(quryset.values()) == 0:
                value = RealPerson.objects.create(**jdata)
                value.save()
            else:
                quryset.update(**jdata)
            return Response(serializer.data, status.HTTP_200_OK)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


@api_view(['POST', ])
@permission_classes([AllowAny, ])
def get_person(request):
    """Get data of person"""
    if request.method == 'POST':
        data = request.data
        queryset = RealPerson.objects.all()
        if data['first_name']:
            queryset = queryset.filter(name=data['first_name'])
        if data['last_name']:
            queryset = queryset.filter(surname=data['last_name'])
        # print("data", queryset.values())
        return Response(queryset.values(), status=status.HTTP_200_OK)



def get_company_a_data(first_name, last_name):
    """Get the data from company A"""
    url = "http://172.27.0.1:8200/companya/search-person/"
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    print("Company A data is Okay")
    payload = {
        "first_name": first_name,
        "last_name": last_name
    }
    res = requests.post(url, json=payload, headers=headers)
    return res.json()


def get_company_b_data(first_name, last_name):
    """Get the data from company B"""
    url = "http://172.27.0.1:8202/companyb/search-person/"
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    print("Company B data is Okay")
    payload = {
        "fname": first_name,
        "lname": last_name
    }
    res = requests.post(url, json=payload, headers=headers)
    return res.json()


def format_data(payload):
    """Send data to get format"""
    url = "http://172.27.0.1:8300/api/data-format/"
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    print("Is on going")
    res = requests.post(url, json=payload, headers=headers)
    return res.json()
