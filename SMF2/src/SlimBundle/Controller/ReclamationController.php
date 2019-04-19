<?php

namespace SlimBundle\Controller;


use SlimBundle\Entity\Reclamation;
use SlimBundle\Entity\Vote;
use SlimBundle\Form\ReclamationType;
use SlimBundle\Form\VoteType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class ReclamationController extends Controller
{


    public function ajoutReclamationAction(Request $request)
    {
        $Reclamation = new Reclamation();

        $form = $this->createForm(ReclamationType::class, $Reclamation);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $Reclamation->setCommentaire(" ");
            $Reclamation->setEtat(0);
            $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
            $idd= $this->getUser()->getId() ;
            $Reclamation->setIdutilisateur($idd);
            $em->persist($Reclamation);
            $em->flush();
            return $this->redirectToRoute("ajoutReclamation");
        }
        return $this->render("@Slim/Front/AjouterReclamation.html.twig",
            array('Reclamation_form' => $form->createView()));
    }
    public function afficherReclamationAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();
        $active = $em->getRepository("SlimBundle:Reclamation")->findAll();

        $Reclamation = $this->get('knp_paginator')
            ->paginate($active, $request->query->get('page', 1), 5);
        return $this->render('@Slim/Back/afficherReclamation.html.twig', array('Reclamation' => $Reclamation,));
    }
        public function SupprimerReclamationAction($idreclamation)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Reclamation::class)->find($idreclamation);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("AfficherReclamation");
    }

    public function ModifierReclamationAction($idreclamation,Request $request){
        $em= $this->getDoctrine()->getManager();
        $ac=$em->getRepository("SlimBundle:Reclamation")->TraiteReclamation($idreclamation);
        $cars=$this->getDoctrine()->getRepository(Reclamation::class)->find($idreclamation);
        $form=$this->createForm(ReclamationType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("AfficherReclamation");
        }
        return $this->render("@Slim/Back/ModifierReclamation.html.twig",array("form_modifier"=>$form->createView()));
    }

    public function AfficherNonReclamationAction(){
        $em= $this->getDoctrine()->getManager();
        $active=$em->getRepository("SlimBundle:Reclamation")->ReclamationNonTraite();
        return $this->render('@Slim/Back/AfficherNonReclamation.html.twig', array("Reclamation"=>$active));
    }
    public function AfficherOuiReclamationAction(){
        $em= $this->getDoctrine()->getManager();
        $active=$em->getRepository("SlimBundle:Reclamation")->ReclamationTraite();
        return $this->render('@Slim/Back/AfficherOuiReclamation.html.twig', array("Reclamation"=>$active));
    }
}
