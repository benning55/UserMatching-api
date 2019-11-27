from django.shortcuts import render

import json
import requests
from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view, permission_classes
from rest_framework.permissions import AllowAny


@api_view(['POST', ])
@permission_classes([AllowAny, ])
def format_data(request):
    """ Make data to the same format """
    if request.method == 'POST':
        data_out = []
        data = request.data

        name_check = ["name", "fname", "f-name", "f_name",
                      "firstname", "first-name", "first_name"]
        surname_check = ["lastname", "last-name", "last_name", "lname", "l-name",
                         "l_name", "sname", "s-name", "s_name", "surname", "sur-name", "sur_name"]
        card_id_check = ["card_id", "cardid", "Card_id", "cardnumber", "card_number", "Cardnumber",
                         "Card_number", "personal_id", "Personal_id", "personal-id", "Personal-id", "id_card_number"]
        address_check = ["address", "local", "location",
                         "abode", "habitation", "residence", "residency"]
        phone_check = ["phone", "phonenumber",
                       "phone-number", "phone_number", "tel", "call"]
        gender_check = ["gender", "sex"]
        gender_m_type_check = ["m", "male", "man"]
        gender_f_type_check = ["fm", "f", "female", "women"]
        email = ["email", "mail"]

        for company in data:
            defineformat = {"name": "", "surname": "", "personal_id": "",
                            "address": "", "phone": "", "gender": ""}
            for detail in data[company][0]:
                if str(detail).lower() in name_check:
                    defineformat.update({"name": data[company][0][detail]})

                elif str(detail).lower() in surname_check:
                    defineformat.update({"surname": data[company][0][detail]})

                elif str(detail).lower() in card_id_check:
                    defineformat.update({"personal_id": data[company][0][detail]})

                elif str(detail).lower() in address_check:
                    defineformat.update({"address": data[company][0][detail]})

                elif str(detail).lower() in phone_check:
                    defineformat.update({"phone": data[company][0][detail]})

                elif str(detail).lower() in gender_check:
                    if data[company][0][detail] in gender_m_type_check:
                        defineformat.update({"gender": "male"})
                    elif data[company][0][detail] in gender_f_type_check:
                        defineformat.update({"gender": "female"})

                elif str(detail).lower() in email:
                    defineformat.update({"email": data[company][0][detail]})

            data_out.append(defineformat)

            to_mek = match_percent(data_out)
            print("to_mek", to_mek)
        return Response(data_out, status=status.HTTP_200_OK)
    return Response(status.HTTP_400_BAD_REQUEST)


def match_percent(payload):
    """Send data to get format"""
    url = "http://172.27.0.1:8400/to-percent/"  # ลิงค์นี้ใส่ url เมฆ
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    print("Is on going")
    res = requests.post(url, json=payload, headers=headers)
    return res.json()

